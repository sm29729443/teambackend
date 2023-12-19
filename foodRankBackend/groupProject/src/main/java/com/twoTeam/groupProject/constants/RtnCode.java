package com.twoTeam.groupProject.constants;

public enum RtnCode {

    // �C�| 200 400 401 403 404
    // �䪺��200 �䤣��404 �ѤU400
    // 401 403 ���v������
    SUCCESSFUL(200, "Successful"), // ���\
    NAMEPARAM_ERROR(400, "Name_Param_error"), // �Ѽƿ��~
    PHONENUMPARAM_ERROR(400, "phone_Param_error"), // �Ѽƿ��~
    ID_ERROR(400,"Id_error"),//id���~
    ID_NOTFOUNT(404,"ID_Notfount"),//�䤣��ID
    NAME_NOTFOUNT(404,"ID_Notfount"),//�䤣��ID
    UPDATE_ERROR(400,"Update_error"),
    STOREINFOPARM_ERROR(400,"StoreInfo_List_error"),
    STORENAMEPARM_ERROR(400,"StoreInfo_Name_List_error"),
    STOREADRESSPARM_ERROR(400,"StoreInfo_Adress_List_error"),
    LOCATION_CITY_ERROR(400, "Location_City_Param_error"),
    DELETE_ERROR(400, "Delete_error"),
    STOREINFO_NULL_ERROR(400, "StoreInfo_Param_error"),
    STORE_ALREADY_EXISTS(400,"The store already exists"), 
    POST_ID_NOT_FOUND(400,"Post_idnot_found"), //�ѼƤw�g�s�b

//	ACCOUNT_EXISTED(400,"Account_existed"),//�b���w�s�b
//	ACCOUNT_NOTFOUNT(404,"Account_Notfount"),//�䤣��b��
//	BALANCE_IS_INSUFFICIENT(400,"Balance is insufficient"),//�l�B����
    ;

    private int code;

    private String message;

    // source -->
    private RtnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // �u���Ψ�getter
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
