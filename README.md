# 專案說明
## 專案架構
專案主體：Spring Boot 2.6.14

Java：8

資料庫：H2（Spring Data JPA）

套件相依：Maven
## 功能簡述：
1. 呼叫coindesk API，解析其下行內容與資料轉換，並實作新的API。
* coindesk API：https://api.coindesk.com/v1/bpi/currentprice.json
2. 建立一張幣別與其對應中文名稱的資料表（需附建立SQL語法），並提供 查詢 / 新增 / 修改 / 刪除 功能API。
3. 撰寫各項功能之單元測試