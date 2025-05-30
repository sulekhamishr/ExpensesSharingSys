package com.java.dao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.model.Users;
import com.java.util.EncryptPassword;
import com.java.util.SessionHelper;

public class UserDaoImpl implements UsersDao {

    Session session;


    @Override
    public boolean registerUser(Users user) {
        boolean isValid = true;
        FacesContext context = FacesContext.getCurrentInstance();

        // Validate name
        if (user.getName() == null || user.getName().length() < 5 || user.getName().length() > 15) {
            context.addMessage("name", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "UserName Invalid", "UserName must be 5 to 15 characters"));
            context.validationFailed();
            isValid = false;
        }

        // Validate password
        if (user.getPassword() == null || user.getPassword().length() < 5) {
            context.addMessage("password", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Password Invalid", "Password must be at least 5 characters"));
            context.validationFailed();
            isValid = false;
        }

        if (!isValid) {
            return false;  // prevent saving if validation fails
        }

        session = SessionHelper.getConnection().openSession();
        Transaction trans = session.beginTransaction();

        // Encrypt password before saving
        user.setPassword(EncryptPassword.getCode(user.getPassword()));

        session.save(user);
        trans.commit();
        session.close();
        
        return true;
    }

	@Override
	public String Login(Users user) {
		// TODO Auto-generated method stub
		
		Session session = SessionHelper.getConnection().openSession();
	    Query query = session.getNamedQuery("Login");
	    query.setParameter("name", user.getName());
	    query.setParameter("password", EncryptPassword.getCode(user.getPassword()));

	    Users result = (Users) query.uniqueResult();
	    session.close();

	    if (result != null) {
	        // Store user in session for JSP access
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggedInUser", result);
	        return "Dashboard?faces-redirect=true";  // Redirect to Dashboard.jsp
	    } else {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", "Invalid credentials"));
	        return "Login?faces-redirect=true";  // Redirect back to Login.jsp
	    }
}
}
