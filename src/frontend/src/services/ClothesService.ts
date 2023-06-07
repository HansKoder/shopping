import http from "../utils/httpCommon";

interface entity {
  id?: number;
  name: string;
  category: string;
  detailSize: string;
  brand: string;
}

class ClothesService {
  getAll() {
    return http.get("/v1/clothes/");
  }

  save(clothes: entity) {
    return http.post("/v1/clothes/", clothes);
  }
}

export default new ClothesService();
