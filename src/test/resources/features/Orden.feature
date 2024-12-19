@todo

Feature: Gestion de orden

  @creacionOrden
  Scenario Outline: Creación de una orden
    Given que tengo la URL del servicio "https://petstore.swagger.io/v2/store/order"
    When realizo una solicitud POST para crear una orden con los datos "<id>", "<petId>", "<quantity>", "<shipDate>", "<status>", "<complete>"
    Then el código de respuesta debe ser 200
    And la respuesta debe contener:
      | clave     | valor                       |
      | id        | 1                           |
      | petId     | 1                           |
      | quantity  | 2                           |
      | shipDate  | 2024-12-18T22:22:35.301Z    |
      | status    | placed                      |
      | complete  | true                        |
    Examples:
    |id | petId | quantity | shipDate                | status | complete |
    |1  |    1  | 2        |2024-12-18T22:22:35.301Z | placed | true     |

  @consultaOrden
  Scenario Outline: Consulta de una orden
    Given que tengo la URL del servicio "https://petstore.swagger.io/v2/store/order/{orderId}"
    When realizo una solicitud GET para consultar una orden con ID "<orderId>"
    Then el código de respuesta debe ser "200"
    And la respuesta debe contener los detalles de la orden
    Examples:
      | orderId |
      | 1       |