<h1>GIS-BIS Task</h1>

### Порядок действий

#### Создание базы данных
```sql
CREATE DATABASE p_geodata;
```
#### Angular
Установка Angular
```
npm install -g @angular/cli
```
Запуск клиента: в командной строке (терминале) перейти к папке проекта с помощью команды cd и затем выполнить команду ng serve:
```
cd render-client
ng serve --open
```

#### Очередность запуска сервисов

- config-service
- eureka-service
- gateway-proxy
- render-service
- render-client
