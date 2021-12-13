# Parking Lot API

## Some considerations:

Due to the lack of business details (which I think is intentional), I would ask some questions about business rules. But as I just had time to do this project during the weekend, I had to come up with some business rules:
- This parking lot has 3 floors.
- The ground floor has spots for taller automobiles, the first floor has spots for medium vehicles, and the second floor has spots for shorter automobiles.
- If a small car approaches and there's no free spot on the second floor, it will search for a spot in the first floor, and if there's no free spots there, it will search for a free spot on the ground floor.
- The pricing per minute is based on the car height. Because I think it's fairer for the customer and also, he/she wouldn't search for another parking lot if all small spots aren't available, and they can park in a bigger spot for the same price. And the parking lot wouldn't loose money since it has free spots anyway.
- Flyway is used to migrate the database.
- The database runs in a Docker container.

## Swagger URL: http://localhost:8080/swagger-ui.html

## JSONs to be used in Postman:

### PUT endpoint at localhost:8080/v1/parking-lot/allocate-vehicle
- The API receives a Json like in this example:
  {
  "weight": 1000,
  "height": 1.75
  }
- It returns a Json like in this example, which can be used to call the emulated POST payment endpoint at localhost:8080/v1/parking-lot/payment:
  {
  "id": 1,
  "initialTime": "2021/12/13 1:12:31",
  "pricePerMinute": 2.00,
  "parkingSpotId": 37,
  "floorName": "first"
  }