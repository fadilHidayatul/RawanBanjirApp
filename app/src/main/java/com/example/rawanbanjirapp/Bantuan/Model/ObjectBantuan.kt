package com.example.rawanbanjirapp.Bantuan.Model

import com.example.rawanbanjirapp.R

object ObjectBantuan {
    private val help  = arrayOf(
        "Ketika pertama kali membuka aplikasi ini akan muncul halaman splash screen dari aplikasi, kemudian akan masuk ke halaman utama. Didalam halaman utama ini terdapat 6 menu yaitu Daerah, Peta, Informasi, About, Bantuan dan Keluar",
        "Jika user memilih menu Daerah maka aplikasi akan menampilkan list /  daftar kecamatan yang ada di kota padang, setelah memilih salah satu kecamatan maka akan muncul kelurahan dari kecamatan yang dipilih, ketika kelurahan dipilih maka akan tampil maps yang menampilkan informasi radius banjir dari kelurahan yang dipilih serta tingkat bahayanya",
        "Jika user memilih menu Peta, maka aplikasi akan menampilkan peta kota Padang beserta sebaran wilayah banjir dikota padang yang diwakili dengan sebuah tanda(marker). Ketika marker di klik maka akan menampilkan informasi banjir dari daerah yang di klik",
        "Jika user memilih menu Informasi, maka aplikasi akan menampilkan informasi / berita terbaru dari daerah yang diupload oleh admin, ketika user mengklik salah satu informasi maka aplikasi akan menampilkan detail dari informasi / berita agar dapat dibaca keterangannya oleh user",
        "Jika user memilih menu About, maka aplikasi akan menampilkan informasi tentang aplikasi serta detail informasi tentang orang yang memiliki aplikasi ini",
        "Jika user memilih menu Bantuan, maka aplikasi akan menampilkan cara penggunaan aplikasi serta fungsi dari menu menu yang ada di halaman utama aplikasi. Jika user ingin keluar dari aplikasi dapat dilakukan dengan menekan menu Keluar"
    )


    val listHelp : ArrayList<Bantuan>
        get() {
            val list = arrayListOf<Bantuan>()

            for (position in help.indices){
                val bantuan = Bantuan()

                bantuan.txtBantuan = help[position]

                list.add(bantuan)
            }
            return list
        }
}