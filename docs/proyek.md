# Spesifikasi Lokasi API

## Menambahkan data proyek

Endpoint : POST /api/proyek


Request Body :

```json
{
  "namaProyek": "Proyek A",
  "client": "Client x",
  "tglMulai": "2024-08-01T10:00:00",
  "tglSelesai": "2024-12-31T17:00:00",
  "pimpinanProyek": "John wick",
  "keterangan": "Proyek untuk pengembangan sistem"
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
  "errors": "gagal menyimpan data proyek"
}
```

##  Menampilkan semua data proyek

Endpoint : GET /api/proyek

Response Body (success) :
```json
{
  "data": [
    {
      "id": 1,
      "namaProyek": "Proyek x",
      "client": "Client 1",
      "tglMulai": "2024-08-01T10:00:00",
      "tglSelesai": "2024-12-31T18:00:00",
      "pimpinanProyek": "Pimpinan y",
      "keterangan": "Proyek pembangunan",
      "createdAt": "2024-08-17T09:58:19.000+00:00"
    },
    {
      "id": 2,
      "namaProyek": "Proyek A",
      "client": "Client XYZ",
      "tglMulai": "2024-08-01T10:00:00",
      "tglSelesai": "2024-12-31T17:00:00",
      "pimpinanProyek": "John Doe",
      "keterangan": "Proyek untuk pengembangan sistem",
      "createdAt": "2024-08-17T10:15:08.000+00:00"
    }
  ],
  "errors": null
}
```

Response Body (failed) :
```json
{
  "data": "failed",
  "errors": "Gagal mendapatkan data proyek"
}
```

## Update / edit data proyek

Endpoint : PATCH /api/proyek/{id}

Request Body :

```json
{
  "namaProyek": "Proyek B",
  "client": "Client yarisu",
  "tglMulai": "2024-08-01T10:00:00",
  "tglSelesai": "2024-12-31T17:00:00",
  "pimpinanProyek": "John Doe",
  "keterangan": "Proyek untuk pengembangan sistem"
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
  "errors": "Gagal mengupdate proyek"
}
```

## Menghapus data proyek

Endpoint : DELETE /api/proyek/{id}

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
  "errors": "Gagal menghapus proyek"
}
```