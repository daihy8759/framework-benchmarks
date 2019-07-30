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
