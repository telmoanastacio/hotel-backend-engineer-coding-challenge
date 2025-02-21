# Hotel Room Allocation

## Build and run the application inside docker in 1 shot ny running the shell script

```shell

sh run.sh
```

## Smoke testing

To perform smoke tests the /occupancy endpoint is exposed at http://localhost:8080/hotel/api/room/occupancy

Pass a request body such as:
```json
{
    "premiumRooms": 7,
    "economyRooms": 5,
    "potentialGuests": [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]
}
```

The expected response should be expected such as:
```json
{
    "usagePremium": 6,
    "revenuePremium": 1054,
    "usageEconomy": 4,
    "revenueEconomy": 189.99
}
```
