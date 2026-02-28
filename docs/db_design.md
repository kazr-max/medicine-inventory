# 薬在庫管理システム_DB詳細設計

## 【1】users テーブル（家族メンバー）
| カラム名 | データ型 | 制約 | 説明 |
| :--- | :--- | :--- | :--- |
| **id** | SERIAL | **主キー** | ユーザーID |
| name | VARCHAR | NOT NULL | 名前（例：「私」「長男」） |

## 【2】medications テーブル（お薬の基本情報）
| カラム名 | データ型 | 制約 | 説明 |
| :--- | :--- | :--- | :--- |
| **id** | SERIAL | **主キー** | 薬ID（APIのURLで使用） |
| **user_id** | INT | **外部キー** | 誰の薬か（users.id） |
| name | VARCHAR | NOT NULL | 薬の名前 |
| type | VARCHAR | NOT NULL | 'DAILY': 常用, 'AS_NEEDED': 頓服 |
| alert_threshold | INT | NOT NULL | 通知ライン（残り何日/何回か） |

## 【3】inventories テーブル（現在の在庫状況）
| カラム名 | データ型 | 制約 | 説明 |
| :--- | :--- | :--- | :--- |
| **medication_id** | INT | **主・外部キー** | 薬ID（medications.idと1対1） |
| remaining_amount| INT | NOT NULL | 現在の残り日数/回数 |
| updated_at | TIMESTAMP | NOT NULL | 最終更新日時 |