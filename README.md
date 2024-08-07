# Potato

“Картошка” - это отечественный электронный кошелек, который позволяет оплачивать услуги, делать денежные переводы в
рамках системы.

Данный проект написан в рамках зимнего интенсива ЦФТ ШИФТ 2024.

Личный вклад в проект:
* создание DTO-объектов
* реализация маппинга
* разработка бизнес-логики
* составление json-запросов и работа с ними в Postman
* реализация взаимодействия с БД (Postgre SQL)
* работа с Git

## Сертификат
<img align="left" alt="C" src="https://github.com/MacIT54/Potato/blob/main/docs/Certificate%20Winter.png" />

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

## Требования к серверной части

* CRU* пользовательский аккаунт
* Возможность войти и выйти из аккаунта
* \*R** пользовательский кошелек
* Отправить перевод
* Выставить счет на оплату за услугу
* Оплатить услугу
* Пополнить кошелек
* Посмотреть историю операций по кошельку

Считаем, что это утилита для администратора в локальной сети без доступа из вне. По этой причине нет никакой авторизации

# Спецификация

## Пользователь

<details>
<summary><strong>GET /users/{id}</strong></summary>
Возвращает информацию о пользователе по его идентификатору

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                   |
|----------|--------------|--------|----------------------------|
| id       | queryParams  | string | идентификатор пользователя |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "id": "uuid",
  "walletId": "string",
  "firstName": "string",
  "lastName": "string",
  "fullName": "string", //firstName + ' ' + lastName
  "email": "string",
  "phone": long,
  "registrationDate": "dd-mm-yyyy",
  "lastUpdateDate": "dd-mm-yyyy",
  "age": int
}
```

</details>

<details>
<summary><strong>POST /users</strong></summary>
Регистрирует нового пользователя

### Request

#### Parameters

| Свойство  | Расположение | Тип    | Описание                                                              |
|-----------|--------------|--------|-----------------------------------------------------------------------|
| phone     | body         | long   | Номер телефона  пьльзователя                                          |
| password  | body         | string | Пароль пользователя                                                   |
| firstName | body         | string | Имя пользователя                                                      |
| lastName  | body         | string | Фамилия пользователя                                                  |
| email     | body         | string | Электронная почта пользователя                                        |
| age       | body         | int    | Возраст пользователя. Допустимый возраст регистрации от 18 до 100 лет |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  // empty
}
```

</details>

<details>
<summary><strong>PATCH /users/{id}</strong></summary>
Обновляет информацию о пользователе

### Request

#### Parameters

| Свойство  | Обязательное | Расположение | Тип    | Описание                       |
|-----------|--------------|--------------|--------|--------------------------------|
| id        | да           | queryParams  | string | Идентификатор пользователя     |
| firstName | нет          | body         | string | Имя пользователя               |
| lastName  | нет          | body         | string | Фамилия пользователя           |
| email     | нет          | body         | string | Электронная почта пользователя |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "id": "uuid",
  "walletId": "string",
  "firstName": "string",
  "lastName": "string",
  "fullName": "string", //firstName + ' ' + lastName
  "email": "string",
  "phone": long,
  "registrationDate": "dd-mm-yyyy",
  "lastUpdateDate": "dd-mm-yyyy",
  "age": int
}
```

</details>

## Сессия

<details>
<summary><strong>GET /users/{userId}/sessions</strong></summary>
Возвращает информацию сессиях пользователя

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                   |
|----------|--------------|--------|----------------------------|
| userId   | queryParams  | string | Идентификатор пользователя |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
[
  {
    "id": "uuid",
    "userId": "uuid",
    "expirationTime": "dd-mm-yyyy",
    "active": boolean
  },
  {
    ...
  }
]
```

</details>

<details>
<summary><strong>GET /users/{userId}/sessions/current</strong></summary>
Возвращает информацию о текущей сессии пользователя

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                   |
|----------|--------------|--------|----------------------------|
| userId   | queryParams  | string | Идентификатор пользователя |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "id": "uuid",
  "userId": "uuid",
  "expirationTime": "dd-mm-yyyy",
  "active": boolean
}
```

</details>

<details>
<summary><strong>POST /users/sessions</strong></summary>
Осуществляет вход пользователя в систему. Возможно иметь несколько активных сессий.

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                                                |
|----------|--------------|--------|---------------------------------------------------------|
| phone    | body         | long   | Номер телефона пользователя, ассоциируемого с аккаунтом |
| password | body         | string | Пароль пользователя                                     |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "id": "uuid",
  "userId": "uuid",
  "token": "string",
  "expirationTime": "dd-mm-yyyy"
}
```

</details>

<details>
<summary><strong>DELETE /users/sessions/{id}</strong></summary>
Удаляет сессию пользователя

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                          |
|----------|--------------|--------|-----------------------------------|
| id       | queryParams  | string | Идентификатор сессии пользователя |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  //empty
}
```

</details>

## Кошелек

<details>
<summary><strong>GET /wallet/bill/{userId}</strong></summary>
Возвращает информацию о счете пользователя

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                   |
|----------|--------------|--------|----------------------------|
| userId   | queryParams  | string | Идентификатор пользователя |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "id": "uuid",
  "amount": long,
  "lastUpdate": "dd-mm-yyyy"
}
```

</details>

### Пополнение кошелька

<details>
<summary><strong>POST /hesoyam </strong></summary>
Пополняет кошелек

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                                                                     |
|----------|--------------|--------|------------------------------------------------------------------------------|
| userId   | body         | string | Идентификатор пользователя                                                   |
| amount   | body         | long   | Количество копеек, зачисляемых на кошелек. Максимальное количество - 1000000 |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "userId": "uuid",
  "billId": "uuid",
  "amount": long
}
```

</details>

## Денежные операции

<details>
<summary><strong>GET /history/{userId} </strong></summary>
Возвращает историю операций по кошельку

### Request

#### Parameters

| Свойство | Обязательный | Расположение  | Тип    | Описание                                                                                                                                                                                                                                                                         |
|----------|--------------|---------------|--------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| userId   | да           | queryParams   | string | Идентификатор пользователя                                                                                                                                                                                                                                                       |
| type     | нет          | filter params | enum   | При указании параметра фильтрации возвращает историю, исходя из типа операции. При `type = transfer` возвращаются операции с переводом денежных средств, при `type = payment` возвращаются операции оплаты услуги, `type = refill` возвращаются операции пополнения своего счета |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
[
  {
    "id": "uuid",
    "userId": "uuid",
    "amount": long,
    "transactionDate": "string",
    "type": "transfer/payment",
    "receiverPhone": long, // optional. Used for type = transfer
    "maintenanceNumber": long, // optional. Used for type = payment,
    "status": "successful"
  }
]
```

</details>

<details>
<summary><strong>POST /transfers </strong></summary>
Денежная транзакция, используемая для оплаты услуги и отправки перевода

### Request

#### Parameters

| Свойство          | Обязательный | Расположение | Тип    | Описание                                                                        |
|-------------------|--------------|--------------|--------|---------------------------------------------------------------------------------|
| userId            | да           | body         | string | Идентификатор отправителя                                                       |
| receiverPhone     | нет          | body         | long   | Номер телефона получателя. Указывается, если не указан maintenanceNumber        |
| maintenanceNumber | нет          | body         | long   | Номер выставленного счета на оплату. Указывается, если не указан  receiverPhone |
| amount            | да           | body         | long   | Количество копеек                                                               |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "id": "uuid",
  "userId": "uuid",
  "wallet": {
    "id": "uuid",
    "amount": long
  }
}
```

</details>

<details>
<summary><strong> GET /maintenance/{userId} </strong></summary>
Возвращает информацию об счетах

### Request

#### Parameters

| Свойство | Обязательное | Расположение  | Тип    | Описание                                                                                           |
|----------|--------------|---------------|--------|----------------------------------------------------------------------------------------------------|
| userId   | да           | queryParams   | string | Идентификатор пользователя                                                                         |
| type     | нет          | filter params | string | Тип счета. Возможные значения: inbound - выставленный счет пользователю, outbound - исзодящий счет |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
[
  {
    "id": "uuid",
    "type": "inbound/outbound",
    "amount": long,
    "maintenanceNumber": long,
    "status": "enum", //paid/unpaid
    "transactionDate": "dd-mm-yyyy"
  }
]
```

</details>

<details>
<summary><strong> POST /maintenance </strong></summary>
Генерирует счет на оплату

### Request

#### Parameters

| Свойство | Расположение | Тип    | Описание                                                              |
|----------|--------------|--------|-----------------------------------------------------------------------|
| userId   | body         | string | Идентификатор пользователя                                            |
| phone    | body         | long   | Номер телефона получателя, который должен будет оплатить обслуживание |
| amount   | body         | long   | Количество копеек                                                     |
| comment  | body         | string | Комментарий копеек                                                    |

### Response

| Http code | Описание       |
|-----------|----------------|
| 200       | Успешный вызов |

Пример:

```json
{
  "id": "uuid",
  "maintenanceNumber": long,
  "status": "enum" //unpaid
}
```

</details>
