## benchmark-vertx
```
➜ wrk -c1000 -d10s http://127.0.0.1:8089
Running 10s test @ http://127.0.0.1:8089
  2 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.49ms   17.13ms 437.92ms   99.21%
    Req/Sec    22.25k     7.06k   29.34k    84.02%
  429816 requests in 10.02s, 18.86MB read
  Socket errors: connect 749, read 200, write 106, timeout 0
Requests/sec:  42912.03
Transfer/sec:      1.88MB
```

## benchmark-vertx-web

```
➜ wrk -c1000 -d10s http://127.0.0.1:8089
Running 10s test @ http://127.0.0.1:8089
  2 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     7.91ms   28.21ms 601.90ms   99.21%
    Req/Sec    20.61k     7.40k   28.04k    81.05%
  390207 requests in 10.03s, 17.12MB read
  Socket errors: connect 749, read 251, write 4, timeout 0
Requests/sec:  38912.84
Transfer/sec:      1.71MB
```

## benchmark-vertx-web-kotlin

```
➜ wrk -c1000 -d10s http://127.0.0.1:8089
Running 10s test @ http://127.0.0.1:8089
  2 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    11.36ms   35.35ms 657.94ms   98.82%
    Req/Sec    13.37k     5.58k   20.27k    73.40%
  250588 requests in 10.04s, 10.99MB read
  Socket errors: connect 749, read 228, write 37, timeout 0
Requests/sec:  24956.65
Transfer/sec:      1.09MB
```

## benchmark-vertx-web-rx

```
➜ wrk -c1000 -d10s http://127.0.0.1:8089
Running 10s test @ http://127.0.0.1:8089
  2 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     7.61ms   23.09ms 520.31ms   98.49%
    Req/Sec    22.54k     7.34k   30.07k    83.85%
  431082 requests in 10.02s, 18.91MB read
  Socket errors: connect 749, read 123, write 0, timeout 0
Requests/sec:  43041.95
Transfer/sec:      1.89MB
```
