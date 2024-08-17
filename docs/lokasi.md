# Spesifikasi Lokasi API

## Menambahkan data lokasi

Endpoint : POST /lokasi


Request Body :

```json
{
  "nama_lokasi": "cianjur",
  "negara": "indonesia",
  "provinsi": "jawa barat",
  "kota": "cianjur"
}
```

Response Body (success):
```json
{
  "status": "success",
  "message": "Berhasil menyimpan data lokasi"
}
```

Response Body (failed):
```json
{
  "status": "failed",
  "error": "gagal menyimpan data lokasi"
}
```

## Menampilkan semua data Lokasi dalam bentuk list

Endpoint : GET /lokasi

Response Body (success) :
```json
{
  "status": "success",
  "data": [
    {
      "lokasi1": {
        "id": "1",
        "nama_lokasi": "cianjur",
        "negara": "indonesia",
        "kota": "cianjur",
        "created_at": "18-agustus-2024"
      },
      "lokasi2": {
        "id": "1",
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
  "error": "Gagal mendapatkan data lokasi"
}
```

## Update / edit data lokasi

Endpoint : PATCH /lokasi/:id

Request Body :

```json
{
  "nama_lokasi": "cianjur",
  "negara": "indonesia",
  "provinsi": "jawa barat",
  "kota": "cianjur"
}
```

Response Body (success) :
```json
{
  "status": "success",
  "message": "lokasi berhasil diupdate"
}
```

Response Body (failed) :
```json
{
  "status": "failed",
  "error": "Gagal mengupdate lokasi"
}
```

## Menghapus data lokasi

Endpoint : DELETE /lokasi/:id

Response Body (success) :
```json
{
  "status": "success",
  "message": "lokasi berhasil dihapus"
}
```

Response Body (failed) :
```json
{
  "status": "failed",
  "error": "Gagal menghapus lokasi"
}
```