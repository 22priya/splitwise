package com.lld.splitwise.expense;

import com.lld.splitwise.expenseGroup.ExpenseGroup;
import com.lld.splitwise.person.Person;
import com.lld.splitwise.split.Split;
import com.lld.splitwise.splitStrategy.SplitStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Expense {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "paidPersonId")
    private Person paidByPerson;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "expense")
    private List<Split> splits;

    @ManyToOne
    @JoinColumn(name="groupId")
    private ExpenseGroup expenseGroup;

    @Transient
    private SplitStrategy splitStrategy;

    private Date date;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPaidByPerson() {
        return paidByPerson;
    }

    public void setPaidByPerson(Person paidByPerson) {
        this.paidByPerson = paidByPerson;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits() {
       this.splitStrategy.getSplits(this);
    }

    public void setSplitStrategy(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    public ExpenseGroup getExpenseGroup() {
        return expenseGroup;
    }

    public void setExpenseGroup(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }
}
