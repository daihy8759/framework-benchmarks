## benchmark-vertx
```
➜ wrk -c1000 -d10s http://127.0.0.1:8089
Running 10s test @ http://127.0.0.1:8089
  2 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.38ms   18.73ms 433.80ms   98.60%
    Req/Sec    25.61k     7.47k   33.06k    88.14%
  494685 requests in 10.01s, 21.70MB read
  Socket errors: connect 749, read 121, write 0, timeout 0
Requests/sec:  49398.50
Transfer/sec:      2.17MB
```

## benchmark-vertx-web

```
➜ wrk -c1000 -d10s http://127.0.0.1:8089
Running 10s test @ http://127.0.0.1:8089
  2 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     5.60ms   14.57ms 400.90ms   99.21%
    Req/Sec    23.73k     8.05k   33.33k    78.35%
  458414 requests in 10.02s, 20.11MB read
  Socket errors: connect 749, read 255, write 7, timeout 0
Requests/sec:  45751.74
Transfer/sec:      2.01MB
```

## benchmark-vertx-web-kotlin

```
➜ wrk -c1000 -d10s http://127.0.0.1:8089
Running 10s test @ http://127.0.0.1:8089
  2 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     8.08ms   24.38ms 564.62ms   99.00%
    Req/Sec    17.61k     6.42k   22.65k    81.77%
  336556 requests in 10.02s, 14.76MB read
  Socket errors: connect 749, read 249, write 19, timeout 0
Requests/sec:  33594.42
Transfer/sec:      1.47MB
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
