import unittest

from sistema import valor_abs

class Test(unittest.TestCase):

  def teste1(self):
    self.assertEqual(10, valor_abs(10))

    