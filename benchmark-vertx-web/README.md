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