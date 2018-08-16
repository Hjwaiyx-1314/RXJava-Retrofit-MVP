package bean;

/**
 * Created by hjw on 2018/2/1.
 */
public class ShopperDetail {
    private boolean result = false;
    private long remoteTime;
    private String shop_id;
    private String shopper_id;
    private String shopName;
    private String minLogo;
    private String bigLogo;
    private String shopperWords;
    private String address;
    private String adminWords;
    private String cityId;
    private String shopperName;
    private String alipayConfig;
    private int CRT_ALIPAY_VERSION_NUM;//支付宝版本号
    private int CTR_AUTO_ACCEPT_ORDER;
    private String CTR_BAG_DESC;//打包
    private double CTR_BAG_PRICE;//打包价
    private double CTR_BOX_PRICE;//餐具费
    private int CTR_INT;
    private int CTR_IS_INPUT_PWD;
    private int CTR_IS_SHOP_PRINT;//是否打印商家联
    private int CTR_ONLINE_ORDER;//在线订单；
    private int CTR_OPEN_PHYSICAL_CARD;//物理卡
    private int CTR_PRINT_ADS;//打印小票广告
    private int CTR_SWEEP_ORDER;
    private int CTR_SWEEP_FIRST_PAYMENT;
    private int CTR_ROOM_PRINT_PAY;
    private int CTR_SET_BOX_MONEY;
    private int CTR_VIP_CHAIN_STORE;
    private int UI_BAG_SHOW;
    private int UI_DISABLE_MAIN_ADS;
    private int UI_IS_DEL_HUNG_PWD;
    private int UI_IS_HAS_PARKING;
    private int UI_IS_HAS_WIFI;
    private int UI_IS_SINGLE;
    private int UI_ORDER_SEQ_SHOW;
    private int UI_OUT_HIDE;
    private String UI_PARKING_PATH;
    private String UI_QRCODE_HIDE;
    private String UI_WIFI_PATH;
    private int CTR_IS_BILL_PAY_PWD;
    private int CTR_ORDER_ADD_GOODS_PRINT;
    private int UI_ADD_GOODS_PERMISSION=1;
    private int CTR_ELEME_AUTHWAY;
    private int CTR_ALIYUN_MQTT;
    private int CTR_OPEN_MESSAGE_EMAIL_PUSH;//是否开启短信邮件
    private int IS_UPDATE_PRICE;//是否修改商品价格
    private int IS_OPEN_HANDOVER; //是否开启交接班

    public int getIS_OPEN_HANDOVER() {
        return IS_OPEN_HANDOVER;
    }

    public void setIS_OPEN_HANDOVER(int IS_OPEN_HANDOVER) {
        this.IS_OPEN_HANDOVER = IS_OPEN_HANDOVER;
    }

    public int getCTR_OPEN_MESSAGE_EMAIL_PUSH() {
        return CTR_OPEN_MESSAGE_EMAIL_PUSH;
    }

    public void setCTR_OPEN_MESSAGE_EMAIL_PUSH(int CTR_OPEN_MESSAGE_EMAIL_PUSH) {
        this.CTR_OPEN_MESSAGE_EMAIL_PUSH = CTR_OPEN_MESSAGE_EMAIL_PUSH;
    }


    public int getCTR_AND_PAY() {
        return CTR_AND_PAY;
    }

    public void setCTR_AND_PAY(int CTR_AND_PAY) {
        this.CTR_AND_PAY = CTR_AND_PAY;
    }

    /*聚合支付：CTR_AND_PAY
             *默认为0 不开通，1 则开通
             */
    private int CTR_AND_PAY;

    public int getCTR_ELEME_AUTHWAY() {
        return CTR_ELEME_AUTHWAY;
    }

    public void setCTR_ELEME_AUTHWAY(int CTR_ELEME_AUTHWAY) {
        this.CTR_ELEME_AUTHWAY = CTR_ELEME_AUTHWAY;
    }

    public String getShopper_id() {
        return shopper_id;
    }

    public void setShopper_id(String shopper_id) {
        this.shopper_id = shopper_id;
    }

    public String getAlipayConfig() {
        return alipayConfig;
    }

    public void setAlipayConfig(String alipayConfig) {
        this.alipayConfig = alipayConfig;
    }

    public int getCTR_IS_BILL_PAY_PWD() {
        return CTR_IS_BILL_PAY_PWD;
    }

    public void setCTR_IS_BILL_PAY_PWD(int CTR_IS_BILL_PAY_PWD) {
        this.CTR_IS_BILL_PAY_PWD = CTR_IS_BILL_PAY_PWD;
    }

    public int getCTR_SWEEP_FIRST_PAYMENT() {
        return CTR_SWEEP_FIRST_PAYMENT;
    }

    public void setCTR_SWEEP_FIRST_PAYMENT(int CTR_SWEEP_FIRST_PAYMENT) {
        this.CTR_SWEEP_FIRST_PAYMENT = CTR_SWEEP_FIRST_PAYMENT;
    }

    public int getCTR_SWEEP_ORDER() {
        return CTR_SWEEP_ORDER;
    }

    public void setCTR_SWEEP_ORDER(int CTR_SWEEP_ORDER) {
        this.CTR_SWEEP_ORDER = CTR_SWEEP_ORDER;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public long getRemoteTime() {
        return remoteTime;
    }

    public void setRemoteTime(long remoteTime) {
        this.remoteTime = remoteTime;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMinLogo() {
        return minLogo;
    }

    public void setMinLogo(String minLogo) {
        this.minLogo = minLogo;
    }

    public String getBigLogo() {
        return bigLogo;
    }

    public void setBigLogo(String bigLogo) {
        this.bigLogo = bigLogo;
    }

    public String getShopperWords() {
        return shopperWords;
    }

    public void setShopperWords(String shopperWords) {
        this.shopperWords = shopperWords;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminWords() {
        return adminWords;
    }

    public void setAdminWords(String adminWords) {
        this.adminWords = adminWords;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getShopperName() {
        return shopperName;
    }

    public void setShopperName(String shopperName) {
        this.shopperName = shopperName;
    }

    public int getCRT_ALIPAY_VERSION_NUM() {
        return CRT_ALIPAY_VERSION_NUM;
    }

    public void setCRT_ALIPAY_VERSION_NUM(int CRT_ALIPAY_VERSION_NUM) {
        this.CRT_ALIPAY_VERSION_NUM = CRT_ALIPAY_VERSION_NUM;
    }

    public int getCTR_AUTO_ACCEPT_ORDER() {
        return CTR_AUTO_ACCEPT_ORDER;
    }

    public void setCTR_AUTO_ACCEPT_ORDER(int CTR_AUTO_ACCEPT_ORDER) {
        this.CTR_AUTO_ACCEPT_ORDER = CTR_AUTO_ACCEPT_ORDER;
    }

    public String getCTR_BAG_DESC() {
        return CTR_BAG_DESC;
    }

    public void setCTR_BAG_DESC(String CTR_BAG_DESC) {
        this.CTR_BAG_DESC = CTR_BAG_DESC;
    }

    public double getCTR_BAG_PRICE() {
        return CTR_BAG_PRICE;
    }

    public void setCTR_BAG_PRICE(double CTR_BAG_PRICE) {
        this.CTR_BAG_PRICE = CTR_BAG_PRICE;
    }

    public double getCTR_BOX_PRICE() {
        return CTR_BOX_PRICE;
    }

    public void setCTR_BOX_PRICE(double CTR_BOX_PRICE) {
        this.CTR_BOX_PRICE = CTR_BOX_PRICE;
    }

    public int getCTR_INT() {
        return CTR_INT;
    }

    public void setCTR_INT(int CTR_INT) {
        this.CTR_INT = CTR_INT;
    }

    public int getCTR_IS_INPUT_PWD() {
        return CTR_IS_INPUT_PWD;
    }

    public void setCTR_IS_INPUT_PWD(int CTR_IS_INPUT_PWD) {
        this.CTR_IS_INPUT_PWD = CTR_IS_INPUT_PWD;
    }

    public int getCTR_IS_SHOP_PRINT() {
        return CTR_IS_SHOP_PRINT;
    }

    public void setCTR_IS_SHOP_PRINT(int CTR_IS_SHOP_PRINT) {
        this.CTR_IS_SHOP_PRINT = CTR_IS_SHOP_PRINT;
    }

    public int getCTR_ONLINE_ORDER() {
        return CTR_ONLINE_ORDER;
    }

    public void setCTR_ONLINE_ORDER(int CTR_ONLINE_ORDER) {
        this.CTR_ONLINE_ORDER = CTR_ONLINE_ORDER;
    }

    public int getCTR_OPEN_PHYSICAL_CARD() {
        return CTR_OPEN_PHYSICAL_CARD;
    }

    public void setCTR_OPEN_PHYSICAL_CARD(int CTR_OPEN_PHYSICAL_CARD) {
        this.CTR_OPEN_PHYSICAL_CARD = CTR_OPEN_PHYSICAL_CARD;
    }

    public int getCTR_PRINT_ADS() {
        return CTR_PRINT_ADS;
    }

    public void setCTR_PRINT_ADS(int CTR_PRINT_ADS) {
        this.CTR_PRINT_ADS = CTR_PRINT_ADS;
    }

    public int getCTR_ROOM_PRINT_PAY() {
        return CTR_ROOM_PRINT_PAY;
    }

    public void setCTR_ROOM_PRINT_PAY(int CTR_ROOM_PRINT_PAY) {
        this.CTR_ROOM_PRINT_PAY = CTR_ROOM_PRINT_PAY;
    }

    public int getCTR_SET_BOX_MONEY() {
        return CTR_SET_BOX_MONEY;
    }

    public void setCTR_SET_BOX_MONEY(int CTR_SET_BOX_MONEY) {
        this.CTR_SET_BOX_MONEY = CTR_SET_BOX_MONEY;
    }

    public int getCTR_VIP_CHAIN_STORE() {
        return CTR_VIP_CHAIN_STORE;
    }

    public void setCTR_VIP_CHAIN_STORE(int CTR_VIP_CHAIN_STORE) {
        this.CTR_VIP_CHAIN_STORE = CTR_VIP_CHAIN_STORE;
    }

    public int getUI_BAG_SHOW() {
        return UI_BAG_SHOW;
    }

    public void setUI_BAG_SHOW(int UI_BAG_SHOW) {
        this.UI_BAG_SHOW = UI_BAG_SHOW;
    }

    public int getUI_DISABLE_MAIN_ADS() {
        return UI_DISABLE_MAIN_ADS;
    }

    public void setUI_DISABLE_MAIN_ADS(int UI_DISABLE_MAIN_ADS) {
        this.UI_DISABLE_MAIN_ADS = UI_DISABLE_MAIN_ADS;
    }

    public int getUI_IS_DEL_HUNG_PWD() {
        return UI_IS_DEL_HUNG_PWD;
    }

    public void setUI_IS_DEL_HUNG_PWD(int UI_IS_DEL_HUNG_PWD) {
        this.UI_IS_DEL_HUNG_PWD = UI_IS_DEL_HUNG_PWD;
    }

    public int getUI_IS_HAS_PARKING() {
        return UI_IS_HAS_PARKING;
    }

    public void setUI_IS_HAS_PARKING(int UI_IS_HAS_PARKING) {
        this.UI_IS_HAS_PARKING = UI_IS_HAS_PARKING;
    }

    public int getUI_IS_HAS_WIFI() {
        return UI_IS_HAS_WIFI;
    }

    public void setUI_IS_HAS_WIFI(int UI_IS_HAS_WIFI) {
        this.UI_IS_HAS_WIFI = UI_IS_HAS_WIFI;
    }

    public int getUI_IS_SINGLE() {
        return UI_IS_SINGLE;
    }

    public void setUI_IS_SINGLE(int UI_IS_SINGLE) {
        this.UI_IS_SINGLE = UI_IS_SINGLE;
    }

    public int getUI_ORDER_SEQ_SHOW() {
        return UI_ORDER_SEQ_SHOW;
    }

    public void setUI_ORDER_SEQ_SHOW(int UI_ORDER_SEQ_SHOW) {
        this.UI_ORDER_SEQ_SHOW = UI_ORDER_SEQ_SHOW;
    }

    public int getUI_OUT_HIDE() {
        return UI_OUT_HIDE;
    }

    public void setUI_OUT_HIDE(int UI_OUT_HIDE) {
        this.UI_OUT_HIDE = UI_OUT_HIDE;
    }

    public String getUI_PARKING_PATH() {
        return UI_PARKING_PATH;
    }

    public void setUI_PARKING_PATH(String UI_PARKING_PATH) {
        this.UI_PARKING_PATH = UI_PARKING_PATH;
    }

    public String getUI_QRCODE_HIDE() {
        return UI_QRCODE_HIDE;
    }

    public void setUI_QRCODE_HIDE(String UI_QRCODE_HIDE) {
        this.UI_QRCODE_HIDE = UI_QRCODE_HIDE;
    }

    public String getUI_WIFI_PATH() {
        return UI_WIFI_PATH;
    }

    public void setUI_WIFI_PATH(String UI_WIFI_PATH) {
        this.UI_WIFI_PATH = UI_WIFI_PATH;
    }

    public int getCTR_ORDER_ADD_GOODS_PRINT() {
        return CTR_ORDER_ADD_GOODS_PRINT;
    }

    public void setCTR_ORDER_ADD_GOODS_PRINT(int CTR_ORDER_ADD_GOODS_PRINT) {
        this.CTR_ORDER_ADD_GOODS_PRINT = CTR_ORDER_ADD_GOODS_PRINT;
    }

    public int getUI_ADD_GOODS_PERMISSION() {
        return UI_ADD_GOODS_PERMISSION;
    }

    public void setUI_ADD_GOODS_PERMISSION(int UI_ADD_GOODS_PERMISSION) {
        this.UI_ADD_GOODS_PERMISSION = UI_ADD_GOODS_PERMISSION;
    }

    public int getCTR_ALIYUN_MQTT() {
        return CTR_ALIYUN_MQTT;
    }

    public void setCTR_ALIYUN_MQTT(int CTR_ALIYUN_MQTT) {
        this.CTR_ALIYUN_MQTT = CTR_ALIYUN_MQTT;
    }

    public int getIS_UPDATE_PRICE() {
        return IS_UPDATE_PRICE;
    }

    public void setIS_UPDATE_PRICE(int IS_UPDATE_PRICE) {
        this.IS_UPDATE_PRICE = IS_UPDATE_PRICE;
    }
}
