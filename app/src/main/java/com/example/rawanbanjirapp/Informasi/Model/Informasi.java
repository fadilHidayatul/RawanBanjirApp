package com.example.rawanbanjirapp.Informasi.Model;

import java.util.List;

public class Informasi {

    /**
     * success : 1
     * status : 200
     * message : Data ada
     * DATA : [{"id_info":"1","judul":"Informasi Banjir Di Sawahan","isi":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Cursus turpis massa tincidunt dui ut ornare. Enim praesent elementum facilisis leo vel. Id aliquet lectus proin nibh nisl condimentum id venenatis. Ut eu sem integer vitae. Elementum nisi quis eleifend quam. Eu turpis egestas pretium aenean pharetra magna ac placerat vestibulum. Suspendisse interdum consectetur libero id faucibus nisl tincidunt.","tgl":"2021-04-13","foto":"jati.jpg","id_admin":"2"},{"id_info":"2","judul":"Informasi Banjir Di Kuranji","isi":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Cursus turpis massa tincidunt dui ut ornare. Enim praesent elementum facilisis leo vel. Id aliquet lectus proin nibh nisl condimentum id venenatis. Ut eu sem integer vitae. Elementum nisi quis eleifend quam. Eu turpis egestas pretium aenean pharetra magna ac placerat vestibulum. Suspendisse interdum consectetur libero id faucibus nisl tincidunt.","tgl":"2021-04-02","foto":"Kuranji.jpg","id_admin":"2"},{"id_info":"3","judul":"test","isi":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.","tgl":"2020-10-11","foto":"jati.jpg","id_admin":"2"}]
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
         * id_info : 1
         * judul : Informasi Banjir Di Sawahan
         * isi : Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Cursus turpis massa tincidunt dui ut ornare. Enim praesent elementum facilisis leo vel. Id aliquet lectus proin nibh nisl condimentum id venenatis. Ut eu sem integer vitae. Elementum nisi quis eleifend quam. Eu turpis egestas pretium aenean pharetra magna ac placerat vestibulum. Suspendisse interdum consectetur libero id faucibus nisl tincidunt.
         * tgl : 2021-04-13
         * foto : jati.jpg
         * id_admin : 2
         */

        private String id_info;
        private String judul;
        private String isi;
        private String tgl;
        private String foto;
        private String id_admin;

        public String getId_info() {
            return id_info;
        }

        public void setId_info(String id_info) {
            this.id_info = id_info;
        }

        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getIsi() {
            return isi;
        }

        public void setIsi(String isi) {
            this.isi = isi;
        }

        public String getTgl() {
            return tgl;
        }

        public void setTgl(String tgl) {
            this.tgl = tgl;
        }

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
        }

        public String getId_admin() {
            return id_admin;
        }

        public void setId_admin(String id_admin) {
            this.id_admin = id_admin;
        }
    }
}
