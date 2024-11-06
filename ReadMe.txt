The Paging 3 Library is a new library to fetch and display pages of data from a large data set from API or Database.


Loading data on Demand needs following things implemented correctly.
1. Keep track of keys
   1. To request the next or previous page
2. Request the correct next page
   1. When user scroll at the end of the loaded data
3. Prevent Duplicate request 


Paging Does all of this for Us. 
Apart from above it also does 
1. Tracks Loading States
2. Retry Functionality on Failed Load
3. Refreshing the List is Only a One Method call Away
4. List Transformation before display 
   1. ( ex 👍 map, filters ) 
5. List separators Implementation 




Paging 3 With Database + Network
* We always read the data from the local database as the single source of truth for the UI.
* And only request more from the Network on the First load or when the database is Exhausted.
* Paging3 is built to support this exact architecture.


  



Let’s Talk about the data layer or More specifically repository ?
* If we are loading data from a single Source like network, local database or file implement the paging source? Where Room Implements the Paging Source for Us.
* If we are loading data from layer source
   * Like Network Datasource with a local database cache. Implement Remote Mediator 
   * To retrieve and save remote data and the paging source for the local database cache.




* At this time I completed my second task on Pagination. Here are a few important discoveries or information about pagination ?
   * As I know load function return LoadResult< key Type , Data Type >
   * So when i load the page write code like
   * LoadResult.page( data = something ) // this comes from response
   * We need to make sure this something is List<value> where value at 0 or any index is equal to Data type of LoadResult




Offset Philosophy ? 
➕ Suppose if I get Such type of response in every request . 
        {
  "apikey": "62087e8c-c5b8-491a-adf2-bd89ffb81dc3",
  "data": [
    {
      "id": "ba902d6a-b3f0-4d4b-98ee-7ea8f4dad10f",
      "name": "Shubham Verma",
      "country": "India"
    },
    {
      "id": "a445372a-a88c-4012-8edc-4401fe6b3d15",
      "name": "Darshan Rajbongshi",
      "country": "India"
    },
.
.
.
.
],
  "status": "success",
  "info": {
    "hitsToday": 18,
    "hitsUsed": 1,
    "hitsLimit": 100,
    "credits": 0,
    "server": 20,
    "offsetRows": 0,
    "totalRows": 14977,
    "queryTime": 84.7443,
    "s": 0,
    "cache": 0
  }
}


SO here 
🙂  first Api call baseURL + Offset = 0 👍
👏 provide response like above where Data array is a core data we are paginating over at very first call with offset = 0 it provide let’s say x entries of data that 😀 x considered as a page size 
👍each entries are called Rows in above api there are 14977 Rows 
👏 Let’s say page size would be 25 so that means in every call we ask for 25 rows 
* Offset 0 fetches items from index 0 to 24
* Offset 25 fetches items from index 25 to 49 
* Similarly, every request is considered as a single page.
* In above api we nearly have 14977 / 25 pages 


If we call api with offset value as 1 it will construct the page with data at index 1 to 50 
Entry at index 0 will not be accessed.