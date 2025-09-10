# Microservice Demo

This project demonstrates a set of Spring Boot microservices.

### Observability

Every service exposes Prometheus metrics at `/actuator/prometheus` and
includes the Micrometer Prometheus registry. The provided
`docker-compose.yaml` starts Prometheus and Grafana along with the
services. Prometheus is configured to scrape each service and Grafana can
be used to build dashboards for monitoring.

To launch the stack:

```bash
docker-compose up --build
```

Prometheus will be available at http://localhost:9090 and Grafana at
http://localhost:3000.
