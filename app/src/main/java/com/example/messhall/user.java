package com.example.messhall;

public class user {

        private String User_school;            //学校
        private String User_ID;            //学号
        private String User_phone;            //手机
        private String User_pwd;            //密码
        private String User_pwd2;        //密码2

        public user(String user_phone, String user_pwd) {
            this.User_phone = User_phone;
            this.User_pwd = User_pwd;
        }
        public user(String User_school,String User_ID,String User_phone,String User_pwd,String User_pwd2) {
            this.User_school = User_school;
            this.User_ID = User_ID;
            this.User_phone = User_phone;
            this.User_pwd = User_pwd;
            this.User_pwd2 = User_pwd2;
        }

        public String getUser_phone() {
            return User_ID;
        }

        public void setUser_phone(String User_phone) {
            this.User_phone = User_phone;
        }

        public String getUser_pwd() {
            return User_pwd;
        }

        public void setUser_pwd(String User_pwd) {
            this.User_pwd = User_pwd;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + User_phone + '\'' +
                    ", password='" + User_pwd + '\'' +
                    '}';
        }
    }

