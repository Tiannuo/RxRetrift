package com.tikou.library_service.moddle;

/**
 * Created by Administrator on 2016/10/17 0017.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 */

public class TestBean {


    /**
     * success : true
     * dataObject : {"total":108,"shipped":0,"refund":3,"lock":0,"pay":107,"receiptGood":0,"ok":0,"evaluation":4,"pendingPayment":0}
     */

    private boolean success;
    /**
     * total : 108
     * shipped : 0
     * refund : 3
     * lock : 0
     * pay : 107
     * receiptGood : 0
     * ok : 0
     * evaluation : 4
     * pendingPayment : 0
     */

    private DataObjectBean dataObject;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataObjectBean getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObjectBean dataObject) {
        this.dataObject = dataObject;
    }

    public static class DataObjectBean {
        private int total;
        private int shipped;
        private int refund;
        private int lock;
        private int pay;
        private int receiptGood;
        private int ok;
        private int evaluation;
        private int pendingPayment;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getShipped() {
            return shipped;
        }

        public void setShipped(int shipped) {
            this.shipped = shipped;
        }

        public int getRefund() {
            return refund;
        }

        public void setRefund(int refund) {
            this.refund = refund;
        }

        public int getLock() {
            return lock;
        }

        public void setLock(int lock) {
            this.lock = lock;
        }

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        public int getReceiptGood() {
            return receiptGood;
        }

        public void setReceiptGood(int receiptGood) {
            this.receiptGood = receiptGood;
        }

        public int getOk() {
            return ok;
        }

        public void setOk(int ok) {
            this.ok = ok;
        }

        public int getEvaluation() {
            return evaluation;
        }

        public void setEvaluation(int evaluation) {
            this.evaluation = evaluation;
        }

        public int getPendingPayment() {
            return pendingPayment;
        }

        public void setPendingPayment(int pendingPayment) {
            this.pendingPayment = pendingPayment;
        }


        @Override
        public String toString() {
            return "DataObjectBean{" +
                    "total=" + total +
                    ", shipped=" + shipped +
                    ", refund=" + refund +
                    ", lock=" + lock +
                    ", pay=" + pay +
                    ", receiptGood=" + receiptGood +
                    ", ok=" + ok +
                    ", evaluation=" + evaluation +
                    ", pendingPayment=" + pendingPayment +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "success=" + success +
                ", dataObject=" + dataObject +
                '}';
    }
}
