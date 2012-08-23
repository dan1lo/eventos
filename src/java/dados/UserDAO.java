/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.User;

/**
 *
 * @author danilo
 * Classe para utilizar ações do user
 */
public class UserDAO {
    
    Session sessao = HibernateUtil.getSessionFactory().getCurrentSession(); // fabríca de conexões
     
    
    /**
     *
     * @author Danilo Cadastrar usuario
     */
    public void CadastrarUser(User usuario) {

        try {
            Transaction t = sessao.beginTransaction();
            sessao.saveOrUpdate(usuario);
            t.commit();
            //sessao.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }
    
    /**
     *
     * @author Danilo carrega user
     */
      public User carregarUser(Long idUser) {  
        User usuarioCarregado = (User) sessao.get(User.class, idUser);  
        return usuarioCarregado;  
  
    }  
    
     /**
     *
     * @author Danilo BuscaLogin user
     */ 
      
      public User buscaLogin(String login, String senha){
          
          try{
               Transaction t = sessao.beginTransaction();
               Criteria criteria = sessao.createCriteria(User.class);
               criteria.add(org.hibernate.criterion.Restrictions.eq("login", login));
               criteria.add(org.hibernate.criterion.Restrictions.eq("senha", senha));
               return (User) criteria.list().get(0);
          }catch(Exception e){
               System.out.println(e.getMessage());
               return null;
          }
          
      }
   
      
      public User buscaUser(String usuario){
          try{
             // Transaction t = sessao.beginTransaction();
              Criteria criteria = sessao.createCriteria(User.class);
              criteria.add(org.hibernate.criterion.Restrictions.eq("login", usuario));
              return (User) criteria.list().get(0);
          }catch (Exception e){
              
          System.out.println(e.getMessage());
          return null;
               
                }
            }
     }