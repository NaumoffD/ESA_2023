# Отчет/пояснение о проделанной работе в 1 ЛР и результаты
1) Была доабвлена простая модель в posgreSQL хозяева/питомцы со связью один ко многим и следующей связью между ключами. </br>
![image](https://user-images.githubusercontent.com/62326372/209640888-1eb42499-0dbc-4399-9235-754d8dbe7154.png)
![image](https://user-images.githubusercontent.com/62326372/209641114-50180387-e48e-4fb9-85c3-697a0ebf5fc9.png)
2) Был скачан, настроен и подключен к БД сервер.
![image](https://user-images.githubusercontent.com/62326372/209641575-c30204eb-cccc-434d-9f99-552783d094ca.png)
![image](https://user-images.githubusercontent.com/62326372/209641644-fc8013e2-d4fe-42de-9d27-cd631687fadf.png)
3) Созданы бины, сущности и сервлеты для запросов к БД и обработки полученных данных.
4) Сделан простой view layer на jsp для минимального отображения информации и демонстрации работы. </br>
![image](https://user-images.githubusercontent.com/62326372/209642349-3ed29170-85f2-4a08-842a-4337d13bd61d.png)</br>
Добавление питомцев и владельцев соотвественно:</br>
![image](https://user-images.githubusercontent.com/62326372/209642565-9af70670-307e-49cc-8bae-788c35e6f1c9.png)
![image](https://user-images.githubusercontent.com/62326372/209642621-53167aba-3abf-4c0d-99b4-e834538d4db1.png)</br>
Редактирование питомцев и владельцев соотвественно:</br>
![image](https://user-images.githubusercontent.com/62326372/209642725-f80263ba-66c7-4ea5-8df9-ec4db0764b17.png)
![image](https://user-images.githubusercontent.com/62326372/209642770-7d3d9dfa-8bfd-4fe3-913c-d979d3a6db04.png)</br>
Удаление работает сразу по нажатию по кнопке без какого-либо подтвержения. 
После удаления второго владельца - владелец у питомца Шарик сразу стал не указан (Владелец отстуствует). </br>
![image](https://user-images.githubusercontent.com/62326372/209643076-e0e69792-be55-43ea-8426-4815bfc4337d.png)
