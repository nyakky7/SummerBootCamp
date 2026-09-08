package model;

public class DbConfig {
    public static final String URL =
            "jdbc:oracle:thin:@(description="
                    + "(retry_count=20)(retry_delay=3)"
                    + "(address=(protocol=tcps)(port=1522)(host=adb.ap-tokyo-1.oraclecloud.com))"
                    + "(connect_data=(service_name=g8c09a6a8bcac32_z3u87o1g28n1sl7w_low.adb.oraclecloud.com))"
                    + "(security=(ssl_server_dn_match=yes)))";

    public static final String USER = "watanabe";
    public static final String PASSWORD = "Teacher2025";

    // 接続情報を外部から変更できないようにするため、コンストラクタをprivateにする
    private DbConfig() {

    }
}
