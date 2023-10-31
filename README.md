# rewardservice

** Sample cURL to get Customers rewards totals

```shell
curl --location 'http://127.0.0.1:8080/v1/rewards/monthly' \
--header 'Content-Type: application/json' \
--data '[
    {
      "id": 1,
      "fullname": "Pradeep Poluri",
      "transactions": [
        {
          "id": 1,
          "desc": "T1",
          "dateOfPurchase": "2023-07-23 06:25:43 PM",
          "purchaseAmount": 64.34
        },
        {
          "id": 2,
          "desc": "T2",
          "dateOfPurchase": "2023-08-10 10:25:00 AM",
          "purchaseAmount": 75.50
        },
        {
          "id": 3,
          "desc": "T3",
          "dateOfPurchase": "2023-08-23 06:25:00 PM",
          "purchaseAmount": 25.00
        },
        {
          "id": 4,
          "desc": "T4",
          "dateOfPurchase": "2023-09-12 12:00:00 PM",
          "purchaseAmount": 120.40
        },
        {
          "id": 5,
          "desc": "T5",
          "dateOfPurchase": "2023-09-28 05:30:00 PM",
          "purchaseAmount": 156.45
        }
      ]

    },
    {
      "id": 2,
      "fullname": "Kumar Poluri",
      "transactions": [
        {
          "id": 6,
          "desc": "T6",
          "dateOfPurchase": "2023-07-12 11:00:34 AM",
          "purchaseAmount": 45.43
        },
        {
          "id": 7,
          "desc": "T7",
          "dateOfPurchase": "2023-07-29 04:09:40 PM",
          "purchaseAmount": 58.54
        },
        {
          "id": 8,
          "desc": "T8",
          "dateOfPurchase": "2023-08-23 06:25:43 PM",
          "purchaseAmount": 99.99
        },
        {
          "id": 9,
          "desc": "T9",
          "dateOfPurchase": "2023-10-23 12:35:43 PM",
          "purchaseAmount": 130.55
        },
        {
          "id": 10,
          "desc": "T10",
          "dateOfPurchase": "2023-10-29 02:26:43 PM",
          "purchaseAmount": 200.22
        }
      ]
    },
    {
      "id": 3,
      "fullname": "Pradeep Kumar",
      "transactions": [
        {
          "id": 11,
          "desc": "T11",
          "dateOfPurchase": "2023-08-23 06:25:43 PM",
          "purchaseAmount": 178.86
        },
        {
          "id": 12,
          "desc": "T12",
          "dateOfPurchase": "2023-09-06 12:25:43 PM",
          "purchaseAmount": 100.00
        },
        {
          "id": 13,
          "desc": "T13",
          "dateOfPurchase": "2023-09-23 01:25:43 PM",
          "purchaseAmount": 29.36
        },
        {
          "id": 14,
          "desc": "T14",
          "dateOfPurchase": "2023-10-10 10:25:43 AM",
          "purchaseAmount": 54.23
        },
        {
          "id": 15,
          "desc": "T15",
          "dateOfPurchase": "2023-10-23 06:25:43 PM",
          "purchaseAmount": 99.45
        }
      ]

    }
  ]'
```

** Sample cURL to get Customers rewards for each month

```shell
curl --location 'http://127.0.0.1:8080/v1/rewards' \
--header 'Content-Type: application/json' \
--data '[
    {
      "id": 1,
      "fullname": "Pradeep Poluri",
      "transactions": [
        {
          "id": 1,
          "desc": "T1",
          "dateOfPurchase": "2023-07-23 06:25:43 PM",
          "purchaseAmount": 64.34
        },
        {
          "id": 2,
          "desc": "T2",
          "dateOfPurchase": "2023-08-10 10:25:00 AM",
          "purchaseAmount": 75.50
        },
        {
          "id": 3,
          "desc": "T3",
          "dateOfPurchase": "2023-08-23 06:25:00 PM",
          "purchaseAmount": 25.00
        },
        {
          "id": 4,
          "desc": "T4",
          "dateOfPurchase": "2023-09-12 12:00:00 PM",
          "purchaseAmount": 120.40
        },
        {
          "id": 5,
          "desc": "T5",
          "dateOfPurchase": "2023-09-28 05:30:00 PM",
          "purchaseAmount": 156.45
        }
      ]

    },
    {
      "id": 2,
      "fullname": "Kumar Poluri",
      "transactions": [
        {
          "id": 6,
          "desc": "T6",
          "dateOfPurchase": "2023-07-12 11:00:34 AM",
          "purchaseAmount": 45.43
        },
        {
          "id": 7,
          "desc": "T7",
          "dateOfPurchase": "2023-07-29 04:09:40 PM",
          "purchaseAmount": 58.54
        },
        {
          "id": 8,
          "desc": "T8",
          "dateOfPurchase": "2023-08-23 06:25:43 PM",
          "purchaseAmount": 99.99
        },
        {
          "id": 9,
          "desc": "T9",
          "dateOfPurchase": "2023-10-23 12:35:43 PM",
          "purchaseAmount": 130.55
        },
        {
          "id": 10,
          "desc": "T10",
          "dateOfPurchase": "2023-10-29 02:26:43 PM",
          "purchaseAmount": 200.22
        }
      ]
    },
    {
      "id": 3,
      "fullname": "Pradeep Kumar",
      "transactions": [
        {
          "id": 11,
          "desc": "T11",
          "dateOfPurchase": "2023-08-23 06:25:43 PM",
          "purchaseAmount": 178.86
        },
        {
          "id": 12,
          "desc": "T12",
          "dateOfPurchase": "2023-09-06 12:25:43 PM",
          "purchaseAmount": 100.00
        },
        {
          "id": 13,
          "desc": "T13",
          "dateOfPurchase": "2023-09-23 01:25:43 PM",
          "purchaseAmount": 29.36
        },
        {
          "id": 14,
          "desc": "T14",
          "dateOfPurchase": "2023-10-10 10:25:43 AM",
          "purchaseAmount": 54.23
        },
        {
          "id": 15,
          "desc": "T15",
          "dateOfPurchase": "2023-10-23 06:25:43 PM",
          "purchaseAmount": 99.45
        }
      ]

    }
  ]'
```