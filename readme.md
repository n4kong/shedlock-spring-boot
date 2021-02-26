## Shedlock for Spring Boot

Example shedlock library for spring boot. An implementation based on https://github.com/lukas-krecan/ShedLock.

#### Requirements
- Jobs run across cluster
- Only one job can be run at the same time
- Job can be run slower than scheduler

#### Pre-requisite

- MySql
- shedlock Table

````
CREATE TABLE shedlock (
    name VARCHAR(64) NOT NULL, 
    lock_until TIMESTAMP(3) NOT NULL,
    locked_at TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3), 
    locked_by VARCHAR(255) NOT NULL, 
    PRIMARY KEY (name)
);
````   
