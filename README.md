# Отчет/пояснение о проделанной работе в 1 ЛР и результаты
1) Была доабвлена простая модель в posgreSQL хозяева/питомцы со связью один ко многим и следующей связью между ключами. </br>
![image](https://user-images.githubusercontent.com/62326372/209640888-1eb42499-0dbc-4399-9235-754d8dbe7154.png)
![image](https://user-images.githubusercontent.com/62326372/209641114-50180387-e48e-4fb9-85c3-697a0ebf5fc9.png)
2) Был скачан, настроен и подключен к БД сервер.
![image](https://user-images.githubusercontent.com/62326372/209641575-c30204eb-cccc-434d-9f99-552783d094ca.png)
![image](https://user-images.githubusercontent.com/62326372/209641606-22a9a593-0777-4438-b7a6-d4f8346b622c.png)
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
Заметьте, после удаления второго владельца - владелец у питомца Шарик сразу стал не указан (Владелец отстуствует). </br>
![image](https://user-images.githubusercontent.com/62326372/209643076-e0e69792-be55-43ea-8426-4815bfc4337d.png)
# Upd
1) Добавлены аннотация ManyToOne и OneToMany </br>
![image](https://user-images.githubusercontent.com/62326372/210409214-59dc7b80-72f6-4170-8392-67d6d053cc1a.png)
![image](https://user-images.githubusercontent.com/62326372/210409257-eef90544-95f2-4541-9c93-87866172ecfa.png)
2) Добавлен вывод связанных сущностей на главную страницу (животных у своих хозяев) </br>
![image](https://user-images.githubusercontent.com/62326372/210409555-f50ac612-367a-4fb7-a5f2-3fc109e0ef16.png)
![image](https://user-images.githubusercontent.com/62326372/210409618-c2f4f609-a653-424b-ab39-18b24b290ea6.png)
3) Исправлен выбор хозяина (и пол п) - теперь подставляется тот, который был уже присвоен </br>
![image](https://user-images.githubusercontent.com/62326372/210409785-460c18c1-7cd1-4e87-b82f-fe80a71f9fa5.png)
4) Немного изменено форматирование (см. картинки из 2 пункта)
5) Переименованы классы и некоторые методы для большей понятности
P.S. Извините за стиль, я шарпист, там стиль именования немного другой из-за различного синтаксического сахара
