package com.example.meallog;

import com.google.gson.annotations.SerializedName;

public class DietDetailResponse {
    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public class Response {
        @SerializedName("body")
        private Body body;

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

        public class Body {
            @SerializedName("item")
            private Item item;

            public Item getItem() {
                return item;
            }

            public void setItem(Item item) {
                this.item = item;
            }
        }
    }

    public class Item {
        @SerializedName("fdNm")
        private String fdNm; // 음식명

        @SerializedName("clriInfo")
        private String clriInfo; // 칼로리 정보

        public String getFdNm() {
            return fdNm;
        }

        public String getClriInfo() {
            return clriInfo;
        }
    }
}
