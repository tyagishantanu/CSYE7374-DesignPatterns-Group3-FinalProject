package edu.neu.csye7374.Strategy;

public enum OfferStrategy {
    NONE,
    StudentOfferStrategy,
    ExchangeOfferStrategy,
    FamilyOfferStrategy,
    NewMemberOfferStrategy;
    
    public static OfferStrategy getOfferStrategyType(String s) {
        switch (s) {
            case "StudentOfferStrategy":
                return OfferStrategy.StudentOfferStrategy;
            case "ExchangeOfferStrategy":
                return OfferStrategy.ExchangeOfferStrategy;
            case "FamilyOfferStrategy":
                return OfferStrategy.FamilyOfferStrategy;
             case "NewMemberOfferStrategy":
                return OfferStrategy.NewMemberOfferStrategy;
            default:
                return OfferStrategy.NONE;
        }
    }
}
