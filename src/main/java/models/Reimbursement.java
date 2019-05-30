package models;

import java.sql.Date;

import DAO.UsersDAO;

	public class Reimbursement {

		User user = new User();
		UsersDAO userDao = new UsersDAO();
		

	private int reimb_id;	
	private double reimb_amt;
	private String reimb_desc;
	private long reimb_receipt;
	private Date reimb_sub;
//	private Date reimb_resolved;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_typeid;
	private int reimb_statusid;
	
	public Reimbursement () {
	}
	
	public Reimbursement(int reimb_id, double reimb_amt, String reimb_desc, long reimb_receipt, Date reimb_sub,
			Date reimb_resolved, int reimb_author, int reimb_resolver, int reimb_typeid, int reimb_statusid) {
		
		super();
		
		this.reimb_id = reimb_id;
		this.reimb_amt = reimb_amt;
		this.reimb_desc = reimb_desc;
		this.reimb_receipt = reimb_receipt;
		this.reimb_sub = reimb_sub;
//		this.reimb_resolved = reimb_resolved;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_typeid = reimb_typeid;
		this.reimb_statusid = reimb_statusid;
		
	}
	
		public int getReimb_id() {
			return reimb_id;
		}

		public void setReimb_id(int reimb_id) {
			this.reimb_id = reimb_id;
		}

		public double getReimb_amt() {
			return reimb_amt;
		}

		public void setReimb_amt(double reimb_amt) {
			this.reimb_amt = reimb_amt;
		}

		public String getReimb_desc() {
			return reimb_desc;
		}

		public void setReimb_desc(String reimb_desc) {
			this.reimb_desc = reimb_desc;
		}

		public long getReimb_receipt() {
			return reimb_receipt;
		}

		public void setReimb_receipt(long reimb_receipt) {
			this.reimb_receipt = reimb_receipt;
		}

		public Date getReimb_sub() {
			return reimb_sub;
		}

		public void setReimb_sub(Date reimb_sub) {
			this.reimb_sub = reimb_sub;
		}

//		public Date getReimb_resolved() {
//			return reimb_resolved;
//		}
//
//		public void setReimb_resolved(Date reimb_resolved) {
//			this.reimb_resolved = reimb_resolved;
//		}

		public int getReimb_author() {
			return reimb_author;
		}

		public void setReimb_author(int reimb_author) {
			this.reimb_author = reimb_author;
		}

		public int getReimb_resolver() {
			return reimb_resolver;
		}

		public void setReimb_resolver(int reimb_resolver) {
			this.reimb_resolver = reimb_resolver;
		}

		public int getReimb_typeid() {
			return reimb_typeid;
		}

		public void setReimb_typeid(int reimb_typeid) {
			this.reimb_typeid = reimb_typeid;
		}

		public int getReimb_statusid() {
			return reimb_statusid;
		}

		public void setReimb_statusid(int reimb_statusid) {
			this.reimb_statusid = reimb_statusid;
		}
		
		@Override
		public String toString() {
			return "Reimbursement [reimb_amt=" + reimb_amt + ", reimb_desc=" + reimb_desc + ", reimb_receipt="
					+ reimb_receipt + ", reimb_sub=" + reimb_sub + ", reimb_author="
					+ reimb_author + ", reimb_resolver=" + reimb_resolver + ", reimb_typeid=" + reimb_typeid
					+ ", reimb_statusid=" + reimb_statusid + ", reimb_id=" + reimb_id + "]";
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(reimb_amt);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + reimb_author;
			result = prime * result + ((reimb_desc == null) ? 0 : reimb_desc.hashCode());
			result = prime * result + reimb_id;
			result = prime * result + (int) (reimb_receipt ^ (reimb_receipt >>> 32));
//			result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
			result = prime * result + reimb_resolver;
			result = prime * result + reimb_statusid;
			result = prime * result + ((reimb_sub == null) ? 0 : reimb_sub.hashCode());
			result = prime * result + reimb_typeid;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reimbursement other = (Reimbursement) obj;
			if (Double.doubleToLongBits(reimb_amt) != Double.doubleToLongBits(other.reimb_amt))
				return false;
			if (reimb_author != other.reimb_author)
				return false;
			if (reimb_desc == null) {
				if (other.reimb_desc != null)
					return false;
			} else if (!reimb_desc.equals(other.reimb_desc))
				return false;
			if (reimb_id != other.reimb_id)
				return false;
			if (reimb_receipt != other.reimb_receipt)
				return false;
//			if (reimb_resolved == null) {
//				if (other.reimb_resolved != null)
//					return false;
//			} else if (!reimb_resolved.equals(other.reimb_resolved))
//				return false;
			if (reimb_resolver != other.reimb_resolver)
				return false;
			if (reimb_statusid != other.reimb_statusid)
				return false;
			if (reimb_sub == null) {
				if (other.reimb_sub != null)
					return false;
			} else if (!reimb_sub.equals(other.reimb_sub))
				return false;
			if (reimb_typeid != other.reimb_typeid)
				return false;
			return true;
			
		}
}
