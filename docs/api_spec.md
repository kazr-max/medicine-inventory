# 薬在庫管理システム_API詳細設計

## 1. エンドポイント一覧
* **GET /api/v1/inventories/{userId}**
    * 指定したユーザーの全在庫リストを取得。
* **PUT /api/v1/inventories/{medicationId}/consume**
    * 在庫を1つ減らす。通知ラインを下回ればカレンダー更新。
* **PUT /api/v1/inventories/{medicationId}/add**
    * 在庫を補充する（数量はRequest Bodyで指定）。カレンダー更新。
* **POST /api/v1/medications**
    * 新しいお薬を登録し、初期在庫を作成する。

## 2. カレンダー更新ロジック
* 更新タイミング：在庫の減少・補充が行われた際。
* 判定：`remaining_amount < alert_threshold` なら予定を作成、そうでなければ削除。