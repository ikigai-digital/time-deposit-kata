from time_deposit import TimeDeposit, TimeDepositCalculator
import unittest


class TestTimeDepositCalculator(unittest.TestCase):

    def test_calculateInterest(self):
        TEST_DATA = [{
            'planType': 'basic',
            'balance': 1234567.0,
            'days': 45,
            'result': 1235595.81
        }]

        xs = []
        for x in TEST_DATA:
            td = TimeDeposit(planType=x['planType'], balance=x['balance'], days=x['days'])
            xs.append(td)

        calc = TimeDepositCalculator(xs)

        plansWithInterest = calc.calculateInterest()
        self.assertEqual(plansWithInterest[0].balance, TEST_DATA[0]['result'])


if __name__ == '__main__':
    unittest.main()
