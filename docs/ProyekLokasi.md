# Spesifikasi Proyeklokasi API

## Menambahkan data Proyeklokasi

Endpoint : POST /api/proyeklokasi

Request Body :

```json
{
  "proyekId": 4,
  "lokasiId": 3
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
  "data": "failed",
  "errors": "gagal menyimpan data proyeklokasi"
}
```

##  Menampilkan semua data proyek termasuk lokasinya

Endpoint : GET /api/proyeklokasi

Response Body (success) :
```json
{
  "status": "success",
  "data": [
    {
      "id": 12,
      "proyek1": {
        "id": 3,
        "namaProyek": "Proyek A",
        "client": "Client XYZ",
        "tglMulai": "2024-08-01T10:00:00",
        "tglSelesai": "2024-12-31T17:00:00",
        "pimpinanProyek": "John Doe",
        "keterangan": "Proyek untuk pengembangan sistem",
        "createdAt": "2024-08-17T14:32:48.000+00:00"
      },
      "lokasi1": {
        "id": 10,
        "namaLokasi": "kaliurang",
        "negara": "indonesia",
        "provinsi": "jawa barat",
        "kota": "Yogyakarta",
        "createdAt": "2024-08-17T16:28:06.000+00:00"
      }
    }
  ]
}
```

## menghapus data proyeklokasi

Endpoint : POST /api/proyeklokasi/{id}

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
  "data": "failed",
  "errors": "gagal menghapus data proyeklokasi"
}
```