# 薬在庫管理システム：実装実行計画

## フェーズ1: データアクセス層と基盤構築
まずは、データベースに接続し、データを保存・取得できる状態を作ります。

* **Step 1.1: データベース接続設定**
    * `src/main/resources/application.properties` の編集（Supabaseへの接続設定）。
* **Step 1.2: エンティティ（Entity）クラスの作成**
    * `User` (家族メンバー)
    * `Medication` (お薬情報)
    * `Inventory` (在庫情報)
* **Step 1.3: リポジトリ（Repository）インターフェースの作成**
    * Spring Data JPA を使用したデータ操作用のインターフェース作成。

## フェーズ2: コア機能APIの実装
認証なしで、まずは薬の登録や在庫の増減ができるAPIを作成します。

* **Step 2.1: 薬の登録APIの実装**
    * `POST /api/v1/medications`
* **Step 2.2: 在庫リスト取得APIの実装**
    * `GET /api/v1/inventories/{userId}`
* **Step 2.3: 在庫の消費・補充APIの実装**
    * `PUT /api/v1/inventories/{medicationId}/consume`
    * `PUT /api/v1/inventories/{medicationId}/add`

## フェーズ3: 認証・認可機能の実装
セキュリティ要件にある「簡易パスワード＋JWT」を実装し、家族以外のアクセスを制限します。

* **Step 3.1: JWTライブラリの導入とユーティリティ作成**
    * `jjwt` 等のライブラリ追加と、トークン発行・検証クラスの作成。
* **Step 3.2: ログインAPIの実装**
    * 合言葉の検証とJWTの返却。
* **Step 3.3: APIリクエストへの認証フィルター適用**
    * Spring Security 設定による全エンドポイントの保護。

## フェーズ4: 外部連携（Googleカレンダー）
在庫が減った際にカレンダーへ予定を追加し、買い忘れを防ぐ機能を実装します。

* **Step 4.1: Google Calendar API連携設定**
    * サービスアカウントの認証情報（JSON）の配置とクライアント設定。
* **Step 4.2: 在庫変動時のアラート判定とカレンダー更新ロジック実装**
    * 在庫数が `alert_threshold` を下回った際の自動書き込み処理。