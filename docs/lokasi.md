# Spesifikasi Lokasi API

## Menambahkan data lokasi

Endpoint : POST /api/lokasi


Request Body :

```json
{
  "namaLokasi": "kaliurang",
  "negara": "indonesia",
  "provinsi": "jawa barat",
  "kota": "Yogyakarta"
}
```

Response Body (success):
```json
{
  "data": "success",
  "errors": null
}
```

Response Body (failed):
```json
{
  "status": "failed",
  "errors": "gagal menyimpan data lokasi"
}
```

## Menampilkan semua data Lokasi dalam bentuk list

Endpoint : GET /lokasi

Response Body (success) :
```json
{
  "data": [
    {
      "id": 9,
      "namaLokasi": "Lokasi Baru",
      "negara": "Indonesia",
      "provinsi": "Jawa Tengah",
      "kota": "Semarang",
      "createdAt": "2024-08-17T14:53:03.000+00:00"
    },
    {
      "id": 10,
      "namaLokasi": "kaliurang",
      "negara": "indonesia",
      "provinsi": "jawa barat",
      "kota": "Yogyakarta",
      "createdAt": "2024-08-17T16:28:06.000+00:00"
    }
  ],
  "errors": null
}
```

Response Body (failed) :
```json
{
  "data": "failed",
  "errors": "Gagal mendapatkan data lokasi"
}
```

## Update / edit data lokasi

Endpoint : PATCH /api/lokasi/{id}

Request Body :

```json
{
  "namaLokasi": "update lokasi",
  "negara": "Indonesia",
  "provinsi": "yogyakarta",
  "kota": "yogyakarta"
}
```

Response Body (success) :
```json
{
  "data": "success",
  "errors": null
}
```

Response Body (failed) :
```json
{
  "data": "failed",
  "errors": "Gagal mengupdate lokasi"
}
```

## Menghapus data lokasi

Endpoint : DELETE /lokasi/:id

Response Body (success) :
```json
{
  "data": "success",
  "errors": null
}
```

Response Body (failed) :
```json
{
  "data": "failed",
  "errors": "Gagal menghapus lokasi"
}
```