package org.kd.springboot.sample;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class QuotationApi {

    private final List<Quotation> quotations;

    public QuotationApi() {
        this.quotations = List.of(
                new Quotation("One of the most beautiful qualities of true friendship is to understand and to be understood.", "Seneca")
                , new Quotation("Death is the solution to all problems. No man - no problem.", "Joseph Stalin")
                , new Quotation("It is a rough road that leads to the heights of greatness.", "Seneca")
        );
    }

    @GetMapping("/quote")
    public List<Quotation> getQuotation() {
        return this.quotations;
    }

    @PostMapping("/quote")
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return this.quotations.add(quotation);
    }

    @DeleteMapping("/quote")
    public Quotation deleteQuotation(@RequestParam int index) {
        return this.quotations.remove(index);
    }
}
