API Documentation:-

BaseUrl :- http://localhost:8080/atm/v1

DESC :- API to give count of customer in last 24 hour
EndPoint :- customer/count
Method: GET
Headers: Bearer {jwtToken}
Response: {
    "success": true,
    "message": "success",
    "data": {
        "customerCount": 0
    }
}

DESC :- API for providing video/image data based on given time duration
EndPoint :- camera/data
Method: GET
Headers: Bearer {jwtToken}
request :- startDate :data (yyyy-MM-ddTHH:mm:ss.zzz) , endDate : date (yyyy-MM-ddTHH:mm:ss.zzz)
Response:{
    "success": true,
    "message": "success",
    "videoLogs":[{
     documentType:"",
	documentUrl:"",
	atmId:"",
	 deviceId:"",
	 createdDate:""
    }]
    
    }


DESC :- Api for Transaction logs based on filer
EndPoint :- transaction/breakdown
Method :- POST
Header :- Bearer {jwtToken}
Request :- {
    "pageNo":1,
    "pageSize":5,
    "isSuccess":false, //optional
    "start":"", //optional(yyyy-MM-ddTHH:mm:ss.zzz)
    "end":"", //optional (yyyy-MM-ddTHH:mm:ss.zzz)
    "transactionType":"DEPOSIT", //optional
    "failedStatus":"OUT_OF_CASH" //optional
}

Response :- {
    "success": false,
    "totalPageCount": 0,
    "totalCount": 0
}



DESC :- health check API
EndPoint :- health
Method: GET
Response: Application is running
}