/*
MIT License

Copyright (c) 2017 JUAN CALVOPINA M

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.jcalvopinam.service;

import com.jcalvopinam.domain.Contact;
import com.jcalvopinam.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by juanca on 5/20/17.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact find(Long id) {
        return contactRepository.getOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Long id, Contact contact) {
        Contact contactToUpdate = contactRepository.findOne(id);
        contactToUpdate.setAddress(contact.getAddress());
        contactToUpdate.setBirthday(contact.getBirthday());
        contactToUpdate.setCompanyName(contact.getCompanyName());
        contactToUpdate.setEmail(contact.getEmail());
        contactToUpdate.setLastName(contact.getLastName());
        contactToUpdate.setName(contact.getName());
        contactToUpdate.setNickName(contact.getNickName());
        contactToUpdate.setPhoneNumber(contact.getPhoneNumber());
        contactToUpdate.setWebSite(contact.getWebSite());
        return contactRepository.save(contactToUpdate);
    }

    @Override
    public void delete(Long contact) {
        contactRepository.delete(contact);
    }

}
