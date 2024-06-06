package com.example.meallog;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DietListResponse {
    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    // Response 클래스를 정적으로 변경합니다.
    public static class Response {
        @SerializedName("body")
        private Body body;

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

        // Body 클래스를 정적으로 변경합니다.
        public static class Body {
            @SerializedName("items")
            private List<Item> items;

            public List<Item> getItems() {
                return items;
            }

            public void setItems(List<Item> items) {
                this.items = items;
            }
        }
    }

    // Item 클래스를 정적으로 변경합니다.
    public static class Item {
        @SerializedName("cntntsNo")
        private String cntntsNo;

        public String getCntntsNo() {
            return cntntsNo;
        }

        public void setCntntsNo(String cntntsNo) {
            this.cntntsNo = cntntsNo;
        }
    }
}

