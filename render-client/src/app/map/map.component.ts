import { Component, AfterViewInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import * as L from "leaflet";
import { NgZone } from "@angular/core";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit {
  protected map!: L.Map;
  protected eventSource: EventSource | undefined;


  private initMap(): void {
    this.map = L.map('map', {
      center: [ 59.57, 30.19 ],
      zoom: 10
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
    });

    tiles.addTo(this.map);
    this.map.on('moveend', () => {
      this.getRenderedMetros();
    });
  }


  private getRenderedMetros() {
    let bBoxString = this.map.getBounds().toBBoxString();
    console.log(bBoxString);
    this.eventSource = new EventSource("http://localhost:8082/render/api/v1/" + bBoxString);
    this.eventSource.onmessage = (event: MessageEvent) => {
      this.zone.run(() => {
        const data = JSON.parse(event.data);
        const path = data.linePath;
        let feature = JSON.parse("{ \"type\": \"Feature\", \"propertie\": {}, " +
          "\"geometry\":" + JSON.stringify(path) + "}");
        let style = {"color": data.lineColor};
        L.geoJson(feature, {style: style}).addTo(this.map);
      });
    };
  }

  constructor(private http: HttpClient, private zone: NgZone) { }

  ngAfterViewInit(): void {
    this.initMap();
    this.getRenderedMetros();
  }
}
