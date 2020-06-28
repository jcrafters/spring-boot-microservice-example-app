CREATE USER stockmarketdbuser WITH password 'stockmarketpass';
CREATE DATABASE stock_market_db;
GRANT ALL PRIVILEGES ON DATABASE stock_market_db TO stockmarketdbuser;

CREATE USER stockmarketcrawlerdbuser WITH password 'stockmarketcrawlerpass';
CREATE DATABASE stock_market_crawler_db;
GRANT ALL PRIVILEGES ON DATABASE stock_market_crawler_db TO stockmarketcrawlerdbuser;