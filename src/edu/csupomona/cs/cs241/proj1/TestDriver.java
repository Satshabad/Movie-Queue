/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.csupomona.cs.cs241.proj1;

import java.io.IOException;

/**
 *
 * @author Satshabad
 */
public class TestDriver {

    public static void main(String args[]) throws IOException, ClassNotFoundException {

       PriorityQueue<String> pq = new PriorityQueue<String>(5, 3);
       pq.enqueue("teste1", 2);
       pq.enqueue("teste2", 2);
       pq.enqueue("teste3", 2);
       pq.enqueue("teste4", 2);
       PriorityQueue<String> pqq = new PriorityQueue<String>(pq);

       System.out.println(pq.dequeue());
       System.out.println(pq.dequeue());

       System.err.println(pqq.dequeue());
       System.err.println(pqq.dequeue());
       System.err.println(pqq.dequeue());
       System.err.println(pqq.dequeue());

   }
    }

