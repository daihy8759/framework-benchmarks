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