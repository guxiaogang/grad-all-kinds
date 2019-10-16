#!/usr/bin/env bash
for (( VAR = 0; VAR < 20; ++VAR )) do kubectl exec dns-test -c dns-test -- curl http://service-go/env ; done

kc exec fortio -c fortio /usr/local/bin/fortio -- load -curl http://service-go/env
kc exec fortio -c fortio /usr/local/bin/fortio -- load -curl http://service-node/env
kc exec fortio -c fortio /usr/local/bin/fortio -- load -curl http://httpbin:8000/status/200

kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 10 -qps 0 -n 100 -loglevel Error  http://service-go/env
kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 10 -qps 0 -n 100 -loglevel Error  http://service-node/env
kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 20 -qps 0 -n 200 -loglevel Error  http://httpbin:8000/status/200

kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 20 -qps 0 -n 200 -loglevel Error  http://service-go/env
kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 20 -qps 0 -n 200 -loglevel Error  http://service-node/env

kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 50 -qps 0 -n 500 -loglevel Error  http://service-go/env
kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 50 -qps 0 -n 500 -loglevel Error  http://service-node/env
kc exec fortio -c fortio /usr/local/bin/fortio -- load -c 60 -qps 0 -n 600 -loglevel Error  http://httpbin:8000/status/200

