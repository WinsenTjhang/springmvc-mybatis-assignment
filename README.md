### Task

 	The following sub-functions are completed on the basis of SSM (Spring, Spring-MVC, MyBatis), only RESTful API is provided, and Postman is used for testing.

1. Add new Order (consider concurrency issues as much as possible)
   Verify and save the Order data uploaded by the clients，the initial status of the order is「Pending Payment」
   Verify Content:
    - Valid User (deleted == 0 And status == 1)
    - Valid Product(deleted == 0 And the price must be consistent with the current price on the database)
    - Product quantity greater than 0(zero)

2. Modify Order Status
   Modify the specified order status to 「Paid」
   Verify Content:
    - Whether the order is「Pending Payment」
3. Modify Order Product
   Modify the quantity of an product under a specified order
   Verify Content: 
    - Whether the order is「Pending Payment」
    - Check the validity of the Product Quantity after modification
4. Query the product sales list
   Query the product details, sort by the quantity of the products in the order details from high to low

### 数据表
【用户表: user】
| Description |    Name     | Data type | Length | Primary Key |    Index    |         Remark         |
| :---------: | :---------: | :-------: | :----: | :---------: | :---------: | :--------------------: |
|     ID      |     ID      |   char    |   32   |     yes     |             |                        |
|    编号     |    code     |   char    |   8    |             | uix_user_01 |                        |
|    名称     |    name     |  varchar  |   80   |             |             |                        |
|    状态     |   status    | smallint  |        |             |             | -1: Frozen\| 1: Normal |
|    备注     |   remark    |  varchar  |  200   |             |             |                        |
|   已删除    |   deleted   | smallint  |        |             |             |                        |
|   创建者    |   creator   |   char    |   32   |             |             |                        |
|  创建时间   | create_time |  bigint   |        |             |             |                        |
|             |             |           |        |             |             |                        |

【商品表: product】
| Description |    Name     | Data type | Length | Primary Key |     Index      |  Remark   |
| :---------: | :---------: | :-------: | :----: | :---------: | :------------: | :-------: |
|     ID      |     ID      |   char    |   32   |     yes     |                |           |
|    编号     |    code     |   char    |   8    |             | uix_product_01 |           |
|    名称     |    name     |  varchar  |   80   |             |                |           |
|    单价     |    price    |  bigint   |        |             |                | Unit: Pcs |
|    单位     |    unit     |  varchar  |   10   |             |                |           |
|    备注     |   remark    |  varchar  |  200   |             |                |           |
|   已删除    |   deleted   | smallint  |        |             |                |           |
|   创建者    |   creator   |   char    |   32   |             |                |           |
|  创建时间   | create_time |  bigint   |        |             |                |           |

【订单表: order】
| Description |    Name     | Data type | Length | Primary Key |    Index     |                            Remark                            |
| :---------: | :---------: | :-------: | :----: | :---------: | :----------: | :----------------------------------------------------------: |
|     ID      |     ID      |   char    |   32   |     yes     |              |                             GUID                             |
|  业务日期   |  biz_date   |    int    |   4    |             | ix_order_01  |                           yyyyMMdd                           |
|   订单号    |  order_no   |   char    |   13   |             | uix_order_02 |            Order prefix (s) + yyyyMMdd + 4 digits            |
|    状态     |   status    | smallint  |        |             |              | 1: Pending Payment\| 2: Paid\| 3: Payment Failed\| 4: Refund |
|    备注     |   remark    |  varchar  |  200   |             |              |                                                              |
|   创建者    |   creator   |   char    |   32   |             |              |                           user.ID                            |
|  创建日期   | create_time |  bigint   |        |             |              |               Timestamp in millisecond format                |
|             |             |           |        |             |              |                                                              |
|             |             |           |        |             |              |                                                              |

【订单明细表: order_detail】
| Description |   Name   | Data type | Length | Primary Key |       Index        |                   Remark                   |
| :---------: | :------: | :-------: | :----: | :---------: | :----------------: | :----------------------------------------: |
|     ID      |    ID    |   char    |   32   |     yes     |                    |                    GUID                    |
|   订单号    | order_no |   char    |   13   |             | ix_order_detail_01 |                                            |
|  商品序号   |   seq    |    int    |   4    |             |                    | The serial number of the item in the order |
|   商品ID    | item_id  |   char    |   32   |             | ix_order_detail_02 |                 product.id                 |
|    单价     |  price   |  bigint   |   4    |             |                    |                                            |
|    数量     | quantity |  bigint   |   4    |             |                    |                 Unit: Pcs                  |
|    单位     |   unit   |  varchar  |   10   |             |                    |                                            |
|    备注     |  remark  |  varchar  |  200   |             |                    |                                            |
|             |          |           |        |             |                    |                                            |

【流水表: sys_seq】
| Description | Name  | Data type | Length | Primary Key | Index |                   Remark                   |
| :---------: | :---: | :-------: | :----: | :---------: | :---: | :----------------------------------------: |
|     ID      |  ID   |   char    |   32   |     yes     |       |                    GUID                    |
|     键      |  key  |  varchar  |   20   | uix_seq_01  |       |         Order Prefix(s) + yyyyMMdd         |
|     值      | value | smallint  |        |             |       | The highest order serial number of the day |
|             |       |           |        |             |       |                                            |
|             |       |           |        |             |       |                                            |
|             |       |           |        |             |       |                                            |
|             |       |           |        |             |       |                                            |
|             |       |           |        |             |       |                                            |
|             |       |           |        |             |       |                                            |

「user」和「product」add mock data directly to the database for testing purposes.

