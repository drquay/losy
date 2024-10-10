package services;

import model.Setting;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Hibernate;

import java.util.List;
import java.util.Optional;

public class SettingService {

    public Optional<String> create(String key, String value) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(new Setting(key, value));
            transaction.commit();
            System.out.println("Setting saved successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
        return Optional.of(key);
    }

    public List<Setting> getAll() {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            return session.createQuery("FROM Settings", Setting.class).getResultList();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (transaction != null) {
                transaction.commit();
            }
        }
        return List.of();
    }
}
