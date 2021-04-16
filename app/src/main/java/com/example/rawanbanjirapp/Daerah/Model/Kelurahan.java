package com.example.rawanbanjirapp.Daerah.Model;

import java.util.List;

public class Kelurahan {

    /**
     * success : 1
     * status : 200
     * message : Data Ada
     * DATA : [{"id_kelurahan":"7","id_kecamatan":"2","nama_kelurahan":"Air Pacah"},{"id_kelurahan":"8","id_kecamatan":"2","nama_kelurahan":"Balai Gadang"},{"id_kelurahan":"9","id_kecamatan":"2","nama_kelurahan":"Batang Kabung"}]
     */

    private int success;
    private int status;
    private String message;
    private List<DATABean> DATA;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DATABean> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATABean> DATA) {
        this.DATA = DATA;
    }

    public static class DATABean {
        /**
         * id_kelurahan : 7
         * id_kecamatan : 2
         * nama_kelurahan : Air Pacah
         */

        private String id_kelurahan;
        private String id_kecamatan;
        private String nama_kelurahan;

        public String getId_kelurahan() {
            return id_kelurahan;
        }

        public void setId_kelurahan(String id_kelurahan) {
            this.id_kelurahan = id_kelurahan;
        }

        public String getId_kecamatan() {
            return id_kecamatan;
        }

        public void setId_kecamatan(String id_kecamatan) {
            this.id_kecamatan = id_kecamatan;
        }

        public String getNama_kelurahan() {
            return nama_kelurahan;
        }

        public void setNama_kelurahan(String nama_kelurahan) {
            this.nama_kelurahan = nama_kelurahan;
        }
    }
}
