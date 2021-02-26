#Соотвествие ObjType и наследования интерфейсов Api

| ObjType   | Интерфейс(ы)           | Возможность изменения (поле)      |
| :--------:| :--------------------: | :-------------------------------: |
| NULL      | IObject                | Не требуется                      |
| VAL       | IVObject               | Не требуется                      |
| VAR       | IVObject               | Требуется (value)                 |
| REFERENCE | IVObject               | Не требуется                      |
| METHOD    | IVObject               | Не требуется                      |
| INTERFACE | IObject ~ IFMS ~ IES   | Желательно (везде)                |
| CLASS     | IObject ~ IFMS ~ IES   | Желательно (везде)                |
| PACKAGE   | IVObject               | Требуется (value - List<IObject>) |