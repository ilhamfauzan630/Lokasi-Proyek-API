# Spesifikasi Lokasi API

## Menambahkan data proyek

Endpoint : POST /proyek


Request Body :

```json
{
  "nama_proyek": "proyek1",
  "client": "client1",
  "tgl_mulai": "18-agustus-2024",
  "tgl_selesai": "21-september-2024",
  "pimpinan_proyek": "pimpinan1",
  "keterangan": "deskripsi proyek",
  "created_at": "08-agustus-2024"
}
```

Response Body (success):
```json
{
  "status": "success",
  "message": "Berhasil menyimpan data proyek"
}
```

Response Body (failed):
```json
{
  "status": "failed",
  "error": "gagal menyimpan data proyyek"
}
```

##  Menampilkan semua data proyek termasuk lokasinya

Endpoint : GET /proyek

Response Body (success) :
```json
{
  "status": "success",
  "data": [
    {
      "proyek1": {
        "nama_proyek": "proyek1",
        "client": "client1",
        "tgl_mulai": "18-agustus-2024",
        "tgl_selesai": "21-september-2024",
        "pimpinan_proyek": "pimpinan1",
        "keterangan": "deskripsi proyek",
        "created_at": "08-agustus-2024",
        "id_lokasi": "1",
        "nama_lokasi": "cianjur",
        "negara": "indonesia",
        "kota": "cianjur",
        "created_at": "18-agustus-2024"
      },
      "proyek1": {
        "nama_proyek": "proyek2",
        "client": "client2",
        "tgl_mulai": "18-agustus-2024",
        "tgl_selesai": "21-september-2024",
        "pimpinan_proyek": "pimpinan2",
        "keterangan": "deskripsi proyek",
        "created_at": "08-agustus-2024",
        "id_lokasi": "1",
        "nama_lokasi": "yogyakarta",
        "negara": "indonesia",
        "kota": "bantul",
        "created_at": "19-agustus-2024"
      }
    }
  ]
}
```

Response Body (failed) :
```json
{
  "status": "failed",
  "error": "Gagal mendapatkan data proyek"
}
```

## Update / edit data proyek

Endpoint : PATCH /proyek/:id

Request Body :

```json
{
  "nama_proyek": "proyek1",
  "client": "client1",
  "tgl_mulai": "18-agustus-2024",
  "tgl_selesai": "21-september-2024",
  "pimpinan_proyek": "pimpinan1",
  "keterangan": "deskripsi proyek",
  "created_at": "08-agustus-2024"
}
```

Response Body (success) :
```json
{
  "status": "success",
  "message": "proyek berhasil diupdate"
}
```

Response Body (failed) :
```json
{
  "status": "failed",
  "error": "Gagal mengupdate proyek"
}
```

## Menghapus data proyek

Endpoint : DELETE /proyek/:id

Response Body (success) :
```json
{
  "status": "success",
  "message": "proyek berhasil dihapus"
}
```

Response Body (failed) :
```json
{
  "status": "failed",
  "error": "Gagal menghapus proyek"
}
```

## Menambahkan data lokasi ke proyek

Endpoint : POST /proyek/{idproyek}/lokasi

Request Body :

```json
{
  "id_lokasi": "1"
}
```

Response Body (success):
```json
{
  "status": "success",
  "message": "Berhasil menyimpan data proyek"
}
```

Response Body (failed):
```json
{
  "status": "failed",
  "error": "gagal menyimpan data proyek"
}
```

## menghapus data lokasi proyek

Endpoint : POST /proyek/{idproyek}/lokasi

Request Body :

```json
{
  "id_lokasi": "1"
}
```

Response Body (success):
```json
{
  "status": "success",
  "message": "Berhasil menghapus data proyek"
}
```

Response Body (failed):
```json
{
  "status": "failed",
  "error": "gagal menghapus data proyek"
}
```