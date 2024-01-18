FROM node:latest-alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

FROM node:latest-alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/sample-app /usr/share/nginx/html
RUN -d -p 4200:4200 sample-app-image:latest
