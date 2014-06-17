package com.br.me.trabalho_ban2.controller;

import com.br.me.trabalho_ban2.model.Bibliografiacomplementar;
import com.br.me.trabalho_ban2.controller.util.JsfUtil;
import com.br.me.trabalho_ban2.controller.util.JsfUtil.PersistAction;
import com.br.me.trabalho_ban2.controller.session.BibliografiacomplementarFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("bibliografiacomplementarController")
@SessionScoped
public class BibliografiacomplementarController implements Serializable {

    @EJB
    private com.br.me.trabalho_ban2.controller.session.BibliografiacomplementarFacade ejbFacade;
    private List<Bibliografiacomplementar> items = null;
    private Bibliografiacomplementar selected;

    public BibliografiacomplementarController() {
    }

    public Bibliografiacomplementar getSelected() {
        return selected;
    }

    public void setSelected(Bibliografiacomplementar selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BibliografiacomplementarFacade getFacade() {
        return ejbFacade;
    }

    public Bibliografiacomplementar prepareCreate() {
        selected = new Bibliografiacomplementar();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BibliografiacomplementarCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BibliografiacomplementarUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BibliografiacomplementarDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Bibliografiacomplementar> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Bibliografiacomplementar getBibliografiacomplementar(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Bibliografiacomplementar> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Bibliografiacomplementar> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Bibliografiacomplementar.class)
    public static class BibliografiacomplementarControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BibliografiacomplementarController controller = (BibliografiacomplementarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bibliografiacomplementarController");
            return controller.getBibliografiacomplementar(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Bibliografiacomplementar) {
                Bibliografiacomplementar o = (Bibliografiacomplementar) object;
                return getStringKey(o.getIdBibliografiaComplementar());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Bibliografiacomplementar.class.getName()});
                return null;
            }
        }

    }

}
